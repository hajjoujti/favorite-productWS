pipeline {
    
    agent any 
    
    tools {
        maven "LOCAL_MAVEN"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "*********************CHECKOUT*********************"
                git branch: 'main', url: 'https://github.com/hajjoujti/favorite-productWS.git'
            }
        }
        
        stage('Compile') {
            steps {
                echo "*********************COMPILE*********************"
                sh 'mvn compile'
            }
        }
        
        stage('Test') {
            steps {
                echo "*********************TEST*********************"
                sh 'mvn test'
            }
            
            post {
                success {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo "*********************PACKAGE*********************"
                sh 'mvn package -Dmaven.test.skip=true'
            }
            post {
                always {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            } 
        }
        
        stage('SSH transfer') {
            steps {
                echo "*********************SSH TRANSFER*********************"
                sh 'scp -v -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/favorite-productWS/Dockerfile vagrant@192.168.33.20:/home/vagrant/'
                sh 'scp -v -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/favorite-productWS/target/*.jar vagrant@192.168.33.20:/home/vagrant/'
            }
        }

        stage('Deploy to Staging') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: '2631e1d0-85aa-40f1-a410-57f03f11fe86', keyFileVariable: 'SSH_KEY_FOR_FAVORITE')]){
                    echo "*********************DEPLOY TO STAGING*********************"
                    sh 'ssh -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no vagrant@192.168.33.20 sudo docker stop favorite-productWS || true'
                    sh 'ssh -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no vagrant@192.168.33.20 sudo docker rm favorite-productWS || true'
                    sh 'ssh -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no vagrant@192.168.33.20 sudo docker rmi favorite-productWS || true'
                    sh 'ssh -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no vagrant@192.168.33.20 sudo docker build -t favorite-productWS .'
                    sh 'ssh -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no vagrant@192.168.33.20 sudo docker run -d --name favorite-productWS -p 9092:9092 favorite-productWS'
                }
            }
        }
    }
}