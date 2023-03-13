# Plugin SonarQube Android Test Project

This project aims to demonstrate how to integrate plugin-sonarqube with android project

## Initialization

Before starting, you have to run a sonarqube instance with the ecoCode Android plugin running. Please follow the documentation: https://github.com/green-code-initiative/ecoCode-mobile/blob/main/INSTALL.md.

On the deployed SonarQube instance, configure a project with the following properties:

- Project Key: ecoCode
- Project name: ecoCode
- Save the project login key somewhere

Update the [gradle.properties](gradle.properties) file with the project login key:


```yaml
# Sonar
systemProp.sonar.host.url=http://localhost:9000
systemProp.sonar.projectKey=ecoCode
systemProp.sonar.projectName=ecoCode

#----- Token generated
systemProp.sonar.login=3b950618645d4ed5809944bcb68f5157f99dd0af
```

## Command line

```sh
./gradlew sonarqube -Dsonar.projectKey=ecoCode -Dsonar.host.url=http://localhost:9000 -Dsonar.login=3b950618645d4ed5809944bcb68f5157f99dd0af
```

Where the value of -Dsonar.login is the token which has been generated from sonarqube instance. Update the _projectKey_ if you do not use _ecoCode_ as you project name in SonarQube.

## From IDE

You can launch from android studio `:app[sonarqube]`

