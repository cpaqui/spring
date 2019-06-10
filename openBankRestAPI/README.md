OpenBankRestAPI
=====================================================

This maven project setup as a WAR packaging, with an embedded jetty of the
WAR file being produced by this project.

Quick Start
-----------

    Run application with jetty
    $ mvn clean install cargo:run

    Tests coverage
    $ mvn cobertura:cobertura

Application URLs:

    Unsecure URL
    http://localhost:8080/openBankRestAPI/hello

    Login (HTTP POST)
    http://localhost:8080/openBankRestAPI/login?username=user&password=userPass

    Security URLs
    List all transactions (HTTP GET)
    http://localhost:8080/openBankRestAPI/secure/v1/transactions

    List all transactions by type (HTTP GET)
    http://localhost:8080/openBankRestAPI/secure/v1/transactions/TRANSACTION_TYPE

    Transactions amount by type (HTTP GET)
    http://localhost:8080/openBankRestAPI/secure/v1/transactions/TRANSACTION_TYPE/amount