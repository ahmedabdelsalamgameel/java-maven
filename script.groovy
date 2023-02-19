def buildJar() {
    echo "<- Awesome, you are in build jar stage ->"
    sh "mvn package"
} 

def buildImage() {
    echo "<- Good work ,  this is buildImage stage ->"
    // --> add more steps here for docker login <--
    // here another way to use credentials  "wrapper syntax" way
    withCredentials([
        usernamePassword(credentials: 'Docker_repo',
                            usernameVariable: USERNAME ,
                            passwordVariable: PASSWORD)
    ])
    {
        sh " docker build -t ahmedabdelsalam19/test-app:javaMaven-2.0 . "
        sh " echo $PASSWORD | docker login -u $USERNAME --password-stdin "
        sh " docker push ahmedabdelsalam19/test-app:javaMaven-2.0 "
    }
} 

def deployApp() {
    echo "<- thanks to reach here, this is deploy stage ->"
} 

return this