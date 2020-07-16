pipeline {
    agent any
    stages{
        stage ('API TESTS') {
           steps {
               dir ('api-testes'){
                    git 'https://github.com/phcunha87/rest-tests.git'
                    bat 'mvn test'
               }
                
            }
        }
        stage ('TESTES FUNCIONAIS') {
            steps {
                dir ('teste-funcionais') {
                    git credentialsId: 'Git', url: 'https://github.com/phcunha87/testes-funcionais-dcoker.git'
                    bat 'mvn test'
                    
                }
                
            }
        }
        stage ('QUALITY'){
            steps {
                dir ('alure-qa'){
                    git credentialsId: 'Git', url: 'https://github.com/phcunha87/allure.git'
                    bat 'mvn test'
                   
                }
            }
        }
        stage ('ALLURE REPORT') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
                
            }
        }    
        
    } 
} 


 
    
	


