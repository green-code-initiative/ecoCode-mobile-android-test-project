# Plugin SonarQube Android Test Project

This project aims to demonstrate how to integrate plugin-sonarqube with android project

## Initialization

Before to come here, you have to run a sonarqube instance. See https://git.snapp.fr/creedengo/plugin-sonarqube. When it's done and docker is running, you can continue

On the android project, you have to install sonarqube plugin (already done in project).

```groovy
plugins {
    id 'com.android.application'
    id 'org.sonarqube' version '3.0'  // here we add the plugin
}
```

## Command line

```sh
./gradlew sonarqube -Dsonar.projectKey=ecoCode -Dsonar.host.url=http://localhost:9000 -Dsonar.login=3b950618645d4ed5809944bcb68f5157f99dd0af
```

Where the value of -Dsonar.login is the token which has been generated from sonarqube instance

## From IDE

Define sonar app's credentials in [gradle.properties](gradle.properties) (already done in project, **just update token**)

```yaml
# Sonar
systemProp.sonar.host.url=http://localhost:9000
systemProp.sonar.projectKey=ecoCode
systemProp.sonar.projectName=ecoCode

#----- Token generated
systemProp.sonar.login=3b950618645d4ed5809944bcb68f5157f99dd0af
```

Then you can launch from android studio `:app[sonarqube]`

## Release

For demo purpose, we have popped an instance of sonarqube at https://sonarqube.creedengo.com/. If you need to run scanner on this environment run

```sh
./gradlew sonarqube -Dsonar.projectKey=ecoCode -Dsonar.host.url=https://sonarqube.creedengo.com -Dsonar.login=7aa875347cf70105017724d6757699aada552865
```

Run this command only if you know what you do because this environment is use for other people outside.
