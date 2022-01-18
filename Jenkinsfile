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
                withCredentials([sshUserPrivateKey(credentialsId: '2631e1d0-85aa-40f1-a410-57f03f11fe86', keyFileVariable: 'SSH_KEY_FOR_FAVORITE')]) {
                    echo "*********************SSH TRANSFER*********************"
                    sh 'scp -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/favorite-productWS/Dockerfile vagrant@192.168.33.20:/home/vagrant/productWS/'
                    sh 'scp -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/favorite-productWS/target/*.jar vagrant@192.168.33.20:/home/vagrant/productWS/'
                }
            }
        }

        stage('Deploy to Staging') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: '2631e1d0-85aa-40f1-a410-57f03f11fe86', keyFileVariable: 'SSH_KEY_FOR_FAVORITE')]) {
                    echo "*********************DEPLOY TO STAGING*********************"
                    sh 'ssh -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no vagrant@192.168.33.20 sudo docker stop favorite-product-ws || true'
                    sh 'ssh -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no vagrant@192.168.33.20 sudo docker rm favorite-product-ws || true'
                    sh 'ssh -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no vagrant@192.168.33.20 sudo docker rmi favorite-product-ws || true'
                    sh 'ssh -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no vagrant@192.168.33.20 sudo docker build -t favorite-product-ws /productWS/.'
                    sh 'ssh -i $SSH_KEY_FOR_FAVORITE -v -o StrictHostKeyChecking=no vagrant@192.168.33.20 sudo docker run -d --name favorite-product-ws -p 9094:9092 favorite-product-ws'
                }
            }
        }
    }
}
