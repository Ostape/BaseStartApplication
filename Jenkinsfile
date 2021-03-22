pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
              withGradle {
                sh 'chmod +x ./gradlew test'
              }
            }
        }
    }
}