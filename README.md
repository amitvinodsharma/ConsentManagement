# Consent management

## Table of contents
* [About](#About)
* [Prerequisites](#Prerequisites)
* [Framework libraries](#Framework)
* [API documentation](#To)
* [Running the application](#Running)
* [Deployment using CI/CD pipeline](#Deployment)
* [Test](#Test)

## About
This is Consent Management RESTful API written in Java and Spring Framework. It gets build using Apache-Maven. This project is intended to be a demonstration the working of the API from a Consent management system. In this project, automated unit testing has been done using junit and data mocking for the automated unit tests using Mockito. The data captured through Rest API are being kept in MySQL. This repository is also currently integrated with CI/CD pipeline using Jenkins server on EC2 instances from AWS. 


## Prerequisites
* Java SDK(1.8)
* Spring framework
* Apache-Tomcat server(8.5)
* MySQL(5.6)

## Framework libraries
* Hibernate

It is an ORM (Object Relational Mapping) tool. It's been used in Consent Management for interactions with database and for data persistence using Java Persistence API. It helps in keeping the data layer from rest of the layers.

* Spring

It's an MVC framework designed around DispatchSerlet. All The RESTful Apis in Consent Management is being developed using Spring MVC framework. It helps in seperation of concerns.

* Junit

It is a unit testing framework for the Java programming language. It is important in the development of test-driven development. In Consent management all the development is supported by automated unit testing using junit.

* Mockito

It is a popular mock framework which can be used in conjunction with JUnit. Mockito allows you to create and configure mock objects. In Consent management all the objects needed for unit testing is being done through Mockito.

* Springfox

It is an automated JSON API documentation for API's built with Spring. It's been integrated with framework in Consent Management for the documentation of rest apis by providing swagger files for the same. 

* Maven

Maven is a build automation tool used primarily for Java projects. All the Consent management tools are being built using Maven.

## To view Swagger 2 API docs

* Run the server and browse to http://localhost:8080/ConsentManagement/swagger-ui.html

* Swagger in json format can be found at http://localhost:8080/ConsentManagement/v2/api-docs

## Running the application

1. Clone the repository
git clone https://github.com/amitvinodsharma/ConsentManagement.git

2. Create database with a name "consentmanagement" on MySQL instance. All the tables will get created on runtime by hibernate incase not present in the database.

3. Change the connection string in src/main/webapp/WEB-INF/spring-servlet.xml with your database instance.

3. Build the code using Maven

4. After successfull build, run the project on Tomcat server.


## Deployment using CI/CD pipeline

For Consent management, linux EC2 instances have been used as Jenkins server and Tomcat server.

## Jenkins setup

### 1. Install Jenkins

Get the latest version of jenkins from https://pkg.jenkins.io/redhat-stable/ and install

yum -y install wget
sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
yum -y install jenkins

### 2. Install Java 1.8x on the machine where Jenkins is running

yum install java-1.8*
#yum -y install java-1.8.0-openjdk

### 3. Start Jenkins

#### Start jenkins service
service jenkins start

#### Setup Jenkins to start at boot,
chkconfig jenkins on

### 4. Accessing Jenkins
By default jenkins runs at port 8080, You can access jenkins at

http://YOUR-SERVER-PUBLIC-IP:8080

### 5. Configure Jenkins

- The default Username is `admin`
- Grab the default password 
- Password Location:`/var/lib/jenkins/secrets/initialAdminPassword`
- `Skip` Plugin Installation; _We can do it later_
- Change admin password
   - `Admin` > `Configure` > `Password`
- Configure `java` path
  - `Manage Jenkins` > `Global Tool Configuration` > `JDK`  
- Create another admin user id

## Install Maven on Jenkins

1. Download maven packages https://maven.apache.org/download.cgi onto Jenkins server. In this case, I am using /opt/maven as my installation directory
 - Link : https://maven.apache.org/download.cgi
    ```sh
     # Creating maven directory under /opt
     mkdir /opt/maven
     cd /opt/maven
     # downloading maven version 3.6.0
     wget http://mirrors.estointernet.in/apache/maven/maven-3/3.6.1/binaries/apache-maven-3.6.1-bin.tar.gz
     tar -xvzf apache-maven-3.6.1-bin.tar.gz
     ```
	
1. Setup M2_HOME and M2 paths in .bash_profile of the user and add these to the path variable
   ```sh
   vi ~/.bash_profile
   M2_HOME=/opt/maven/apache-maven-3.6.1
   M2=$M2_HOME/bin
   PAHT=<Existing_PATH>:$M2_HOME:$M2
   ```
#### Checkpoint 
1. logoff and login to check maven version
  
    ```sh
    mvn --version
    ```
So far we have completed the installation of maven software to support maven plugin on the jenkins console. Let's jump onto Jenkins to complete the remaining steps. 

### Setup maven on Jenkins console
1. Install maven plugin without restart  
  - `Manage Jenkins` > `Jenkins Plugins` > `available` > `Maven Invoker`
  - `Manage Jenkins` > `Jenkins Plugins` > `available` > `Maven Integration`

2. Configure maven path
  - `Manage Jenkins` > `Global Tool Configuration` > `Maven`
  

## Test

For testing all of the CRUD actions, I recommend using Postman.
