pipeline {
    agent any
    stages {
        stage('Ktlint') {
            steps {
                echo 'Hello'
            }
        }
        post {
            always {
            echo 'world!'
            }
        }
    }
}