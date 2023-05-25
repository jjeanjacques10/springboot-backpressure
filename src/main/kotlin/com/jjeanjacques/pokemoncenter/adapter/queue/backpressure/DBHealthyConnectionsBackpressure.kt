package com.jjeanjacques.pokemoncenter.adapter.queue.backpressure

import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import java.sql.SQLException
import javax.sql.DataSource

@Service("connections_backpressure")
class DBHealthyConnectionsBackpressure(
        private val healthIndicator: DataSourceHealthIndicator,
        private val dataSource: DataSource
) : Backpressure {

    private val maxConnections = 30 // Define the maximum number of allowed connections

    override fun shouldWait(): Boolean {
        val activeConnections = getActiveConnections()
        return activeConnections >= maxConnections
    }

    private fun getActiveConnections(): Int {
        return try {
            dataSource.connection.use { connection ->
                val statement = connection.createStatement()
                val resultSet = statement.executeQuery("SELECT COUNT(*) AS active_connections FROM INFORMATION_SCHEMA.PROCESSLIST")
                resultSet.next()
                resultSet.getInt("active_connections")
            }
        } catch (ex: SQLException) {
            // Handle the exception accordingly
            throw RuntimeException("Failed to retrieve active connections", ex)
        }
    }
}
