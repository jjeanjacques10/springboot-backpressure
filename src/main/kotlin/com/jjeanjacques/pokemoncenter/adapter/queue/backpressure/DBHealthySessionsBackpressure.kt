package com.jjeanjacques.pokemoncenter.adapter.queue.backpressure

import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import java.sql.SQLException
import javax.sql.DataSource

@Primary
@Service("sessions_backpressure")
class DBHealthySessionsBackpressure(
        private val healthIndicator: DataSourceHealthIndicator,
        private val dataSource: DataSource
) : Backpressure {

    private val maxSessions = 100 // Define the maximum number of allowed sessions

    override fun shouldWait(): Boolean {
        val activeSessions = getActiveSessions()
        return activeSessions >= maxSessions
    }

    private fun getActiveSessions(): Int {
        return try {
            dataSource.connection.use { connection ->
                val statement = connection.createStatement()
                val resultSet = statement.executeQuery("SHOW PROCESSLIST")
                val activeSessions = mutableListOf<String>()
                while (resultSet.next()) {
                    val state = resultSet.getString("State")
                    if (!state.startsWith("Sleep")) {
                        activeSessions.add(state)
                    }
                }
                activeSessions.size
            }
        } catch (ex: SQLException) {
            // Handle the exception accordingly
            throw RuntimeException("Failed to retrieve active sessions", ex)
        }
    }
}