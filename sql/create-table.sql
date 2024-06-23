--- Application: HR Demo
--- version: 0.1-beta

CREATE SCHEMA IF NOT EXISTS HR;

SET search_path TO HR;

CREATE TABLE IF NOT EXISTS HR.departments (
    DEPARTMENT_ID BIGINT PRIMARY KEY NOT NULL,
    DEPARTMENT_NAME VARCHAR(4000) NOT NULL,
    LOCATION_ID BIGINT,
    MANAGER_ID BIGINT,
    TENANT_ID UUID NOT NULL,
    CREATED_AT DATE NOT NULL,
    CREATED_BY VARCHAR(4000) NOT NULL,
    UPDATED_AT DATE NOT NULL,
    UPDATED_BY VARCHAR(4000) NOT NULL,
    REVISION INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS HR.regions (
    REGION_ID BIGINT PRIMARY KEY NOT NULL,
    REGION_NAME VARCHAR(4000) NOT NULL,
    TENANT_ID UUID NOT NULL,
    CREATED_AT DATE NOT NULL,
    CREATED_BY VARCHAR(4000) NOT NULL,
    UPDATED_AT DATE NOT NULL,
    UPDATED_BY VARCHAR(4000) NOT NULL,
    REVISION INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS HR.countries (
    COUNTRY_ID VARCHAR(4000) PRIMARY KEY NOT NULL,
    COUNTRY_NAME VARCHAR(40) NOT NULL,
    REGION_ID BIGINT,
    TENANT_ID UUID NOT NULL,
    CREATED_AT DATE NOT NULL,
    CREATED_BY VARCHAR(4000) NOT NULL,
    UPDATED_AT DATE NOT NULL,
    UPDATED_BY VARCHAR(4000) NOT NULL,
    REVISION INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS HR.locations (
    LOCATION_ID BIGINT PRIMARY KEY NOT NULL,
    STREET_ADDRESS VARCHAR(40),
    POSTAL_CODE VARCHAR(12),
    CITY VARCHAR(30),
    STATE_PROVINCE VARCHAR(25),
    COUNTRY_ID VARCHAR(4000),
    TENANT_ID UUID NOT NULL,
    CREATED_AT DATE NOT NULL,
    CREATED_BY VARCHAR(4000) NOT NULL,
    UPDATED_AT DATE NOT NULL,
    UPDATED_BY VARCHAR(4000) NOT NULL,
    REVISION INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS HR.jobs (
    JOB_ID VARCHAR(4000) PRIMARY KEY NOT NULL,
    JOB_TITLE VARCHAR(40),
    MIN_SALARY NUMERIC(19,2),
    MAX_SALARY NUMERIC(19,2),
    TENANT_ID UUID NOT NULL,
    CREATED_AT DATE NOT NULL,
    CREATED_BY VARCHAR(4000) NOT NULL,
    UPDATED_AT DATE NOT NULL,
    UPDATED_BY VARCHAR(4000) NOT NULL,
    REVISION INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS HR.employees (
    EMPLOYEE_ID BIGINT PRIMARY KEY NOT NULL,
    FIRST_NAME VARCHAR(20) NOT NULL,
    LAST_NAME VARCHAR(25) NOT NULL,
    EMAIL VARCHAR(55) NOT NULL,
    PHONE_NUMBER VARCHAR(20),
    HIRE_DATE DATE NOT NULL,
    JOB_ID VARCHAR(4000) NOT NULL,
    SALARY NUMERIC(19,2),
    commission_pct NUMERIC(19,2),
    MANAGER_ID BIGINT,
    DEPARTMENT_ID BIGINT,
    TENANT_ID UUID NOT NULL,
    CREATED_AT DATE NOT NULL,
    CREATED_BY VARCHAR(4000) NOT NULL,
    UPDATED_AT DATE NOT NULL,
    UPDATED_BY VARCHAR(4000) NOT NULL,
    REVISION INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS HR.job_history (
    JOB_HISTORY_ID BIGINT PRIMARY KEY NOT NULL,
    EMPLOYEE_ID BIGINT NOT NULL,
    START_DATE DATE NOT NULL,
    END_DATE DATE NOT NULL,
    JOB_ID VARCHAR(4000) NOT NULL,
    DEPARTMENT_ID BIGINT NOT NULL,
    TENANT_ID UUID NOT NULL,
    CREATED_AT DATE NOT NULL,
    CREATED_BY VARCHAR(4000) NOT NULL,
    UPDATED_AT DATE NOT NULL,
    UPDATED_BY VARCHAR(4000) NOT NULL,
    REVISION INTEGER NOT NULL
);