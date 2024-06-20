ORM-Based Mass Data Generator

A Java-based project that utilizes Hibernate as an Object-Relational Mapping (ORM) tool to generate large amounts of data and store it in a MySQL database.
Features

    Generates mass data using Java Faker
    Utilizes Hibernate as an ORM tool for database interactions
    Supports MySQL database connectivity using MySQL Connector/J
    Includes a comprehensive set of Data Access Object (DAO) classes for interacting with the database
    Provides a flexible and configurable data generation process

Project Structure

    src/main/java: Java source code for the project
    src/main/resources: Configuration files and resources, including hibernate.cfg.xml

Dependencies

    Hibernate Core (6.0.0.Final)
    Hibernate Entity Manager (6.0.0.Final)
    Java Persistence API (2.2)
    Java Faker (1.0.2)
    MySQL Connector/J (8.0.26)

Getting Started

    Clone the repository
    Configure the hibernate.cfg.xml file to match your database settings
    Run the Main.java class to generate mass data
    Customize the data generation process by modifying the DataGenerator.java class

Contributing

Contributions are welcome! If you'd like to contribute to this project, please fork the repository and submit a pull request.
