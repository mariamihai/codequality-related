# Code Quality related tools

## SonarQube
### Adding SonarQube with Docker
Get the latest community edition and create a container based on it:
```
docker pull sonarqube
docker run -d --name sonarqube -p 9000:9000 sonarqube
docker run --stop-timeout 3600 sonarqube
```
### Using Sonar with a database (not In Memory)
[link](https://docs.sonarqube.org/latest/setup/install-server/)
### Trigger Sonar
```
mvn sonar:sonar \
  -Dsonar.projectKey=org.example:codequality \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=$SONAR_TOKEN
```

## JaCoCo
### Maven Plugin
```
</plugins>
	<plugin>
		<groupId>org.jacoco</groupId>
		<artifactId>jacoco-maven-plugin</artifactId>
		<version>0.7.7.201606060606</version>
		<executions>
			<execution>
				<goals>
					<goal>prepare-agent</goal>
				</goals>
			</execution>
			<execution>
				<id>report</id>
				<phase>test</phase>
				<goals>
					<goal>report</goal>
				</goals>
			</execution>
		</executions>
	</plugin>
</plugins>
```
### Trigger JaCoCo independent of Sonar
Based on the previous configuration, JaCoCo will trigger with the test goal.
```
mvn clean test
```
View report at ‘target/site/jacoco/index.html’
### Trigger JaCoCo and then Sonar
```
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true

mvn sonar:sonar \
  -Dsonar.projectKey=org.example:codequality \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=$SONAR_TOKEN
```
### Important!
Make sure each test starts with "test" otherwise JaCoCo will ignore it.

## Pitest
### Trigger Pitest and then Sonar
```
mvn org.pitest:pitest-maven:mutationCoverage

mvn sonar:sonar -Dsonar.pitest.mode=reuseReport
```
View report at ‘target/site/pit-reports/index.html’

## Links
[SonarScanner for Maven](https://docs.sonarqube.org/latest/analysis/scan/sonarscanner-for-maven/)

[Integrate SonarQube with Maven](https://medium.com/knoldus/how-to-integrate-your-maven-project-with-sonarqube-79f7368f8c7a)

[SonarQube - Baeldung](https://www.baeldung.com/sonar-qube)

[Johan Janssen at Jfokus](https://www.youtube.com/watch?v=wY2Iex6LwMU)

[JaCoCo - Baeldung](https://www.baeldung.com/jacoco)

[PiTest Quickstart](https://pitest.org/quickstart/maven/)
