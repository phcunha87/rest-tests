pipeline {
    agent any
    stages{
        stage ('API TESTS') {
           steps {
                git 'https://github.com/phcunha87/rest-tests.git'
                bat 'mvn test'
            }
        } 
        stage ('TESTES FUNCIONAIS') {
            steps {
                git credentialsId: 'Git', url: 'https://github.com/phcunha87/testes-funcionais-dcoker.git'
                bat 'mvn test'
            }
        }
        post {
          always {
            script {
              allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
              ])
            }
        }
        
    }
    
}       
    
	


