pipeline {
    agent any
    stages {
        stage('Ktlint') {
            steps {
              withGradle {
                sh 'chmod +x ./gradlew'
                sh './gradlew ktlintCheck'
              }
            }
        }
        post {
            always {
                emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
            }
        }
    }
}