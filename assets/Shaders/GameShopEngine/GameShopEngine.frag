#version 330
out vec4 fragColor;
in vec2 outTextCoord;
uniform sampler2D txtSampler;

void main(){
    fragColor = texture(txtSampler, outTextCoord);
}