# Use the official MySQL image as a base
FROM mysql:8.0

# Set environment variables
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=chat_app
ENV MYSQL_USER=ferdy
ENV MYSQL_PASSWORD=ferdy

# Expose MySQL port
EXPOSE 3306

# Copy initialization scripts (optional)
# COPY ./init.sql /docker-entrypoint-initdb.d/

# Default command
CMD ["mysqld"]
