pipeline {
    agent any
        stage ('API Tests'){
            steps {
                dir('api-test'){
                    git 'https://github.com/phcunha87/rest-tests.git'
                    echo 'mvn test'

                }
                
            }
        }
        stage ('Funcional Tests'){
            steps {
                dir('funcional-test'){
                    git 'https://github.com/phcunha87/FuncionalTeste.git'
                    echo 'mvn test'

                }
                
            }
        }
        stage ('Deploy Prod') {
            steps {
                echo 'docker-compose build'
                echo 'docker-compose up -d'
            }
        }
       
	}
}    
	
