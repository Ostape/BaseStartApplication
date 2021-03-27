pipeline {
    agent any
    stages {
        stage('Ktlint') {
            steps {
              withGradle {
                sh 'chmod +x ./gradlew'
                sh './gradlew test'
              }
            }
        }
        stage('Tests') {
            steps {
              withGradle {
                sh 'chmod +x ./gradlew'
                sh './gradlew test'
              }
            }
        }
    }
}