pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'jdk-17'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -f backend/pom.xml clean install -DskipTests -Dorg.jenkinsci.plugins.durabletask.BourneShellScript.LAUNCH_DIAGNOSTICS=true'
            }
        }
        stage('Test-Stage') {
            steps {
                sh 'mvn -f backend/pom.xml test'
            }
        }
    }

    post {
        always {
            publishCoverage adapters: [jacocoAdapter('**/target/site/jacoco/jacoco.xml')]
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
