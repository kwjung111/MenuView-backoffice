plugins {
	java
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "backoffice"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_18
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security:3.0.4")
	implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.2")
	compileOnly("org.projectlombok:lombok:1.18.26")
	developmentOnly("org.springframework.boot:spring-boot-devtools:3.0.4")
	implementation("org.mariadb.jdbc:mariadb-java-client")
	annotationProcessor("org.projectlombok:lombok:1.18.26")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.2")
	testImplementation("org.springframework.security:spring-security-test:6.0.2")
	implementation("org.apache.logging.log4j:log4j-api:2.20.0")
	implementation("org.apache.logging.log4j:log4j-core:2.20.0")
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper:10.1.9")
	implementation("javax.servlet:jstl:1.2")
	implementation("org.springframework.boot:spring-boot-starter-mail")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
