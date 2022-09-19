# soap-service-demo
soap web-service-demo-spring boot server

date=18/09/2022

approach to devlop soap(simple object access protocol) ws\
1) contract fist
wsdl-> java
2) contract last
java-> wsdl(Web Services Description Language)

we are using contact first approch
we did not write WSDL in sprong boot 
we need to write xsd(XML Schema Definition) file
==============================================================================
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web-services</artifactId>
</dependency>

<dependency>
		<groupId>wsdl4j</groupId>
		<artifactId>wsdl4j</artifactId>
</dependency>
=============================================================================
we need to write xsd(XML Schema Definition) file
src/main/resources
and create 
new-other-xml-xml schema file
and give the file name 
loaneligibility.xsd


it will auto generated
<?xml version="1.0" encoding="UTF-8"?>
<schema xmlns="http://www.w3.org/2001/XMLSchema"
	targetNamespace="http://www.example.org/NewXMLSchema"
	xmlns:tns="http://www.example.org/NewXMLSchema"
	elementFormDefault="qualified">
</schema>


write your input request object and output request object in xsd file

for generating bi9ndi9ng classes we need to add one plugin -xjc plugin

============================================================================================
	<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>jaxb2-maven-plugin</artifactId>
				<version>1.6</version>
				<executions>
					<execution>
						<id>xjc</id>
						<goals>
							<goal>xjc</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<schemaDirectory>${project.basedir}/src/main/resources/</schemaDirectory>
					<outputDirectory>${project.basedir}/src/main/java</outputDirectory>
					<clearOutputDir>false</clearOutputDir>
				</configuration>
			</plugin>
===============================================================================

mavn clean and maven install
.setting folder delete if error
auto all java object will created after maven install

new create  endpoint packege and service and config
now write own implementaion
in service class
next service endpoint


now next final step config
we only writing xsd file now for generation wsdl file do some config
java base config file


then last run the project
and hit the url
check wsdl generated or not
http://localhost:8080/ws/loanEligibility.wsdl
url-servlet path-bean name .wsdl

now if ALL IS OK THEN  TEST SOAP UI tool for testing
copy the url
http://localhost:8080/ws/loanEligibility.wsdl
click on soap- give the any project name
and paste the url
![image](https://user-images.githubusercontent.com/75246941/190923037-514239dd-9bb7-4000-be23-07f6cd5d880b.png)


![image](https://user-images.githubusercontent.com/75246941/190922938-5122169c-cea8-4574-9162-bdfa696e7620.png)


for consumer refer the url---https://github.com/Java-Techie-jt/spring-boot-soap-ws-consumer




