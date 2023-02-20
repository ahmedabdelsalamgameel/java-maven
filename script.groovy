def buildJar() {
    echo "<- Awesome, you are in build jar stage ->"
    sh "mvn package"
} 

def buildImage() {
    echo "<- Good work ,  this is buildImage stage ->"
} 

def deployApp() {
    echo "<- thanks to reach here, this is deploy stage ->"
} 

return this