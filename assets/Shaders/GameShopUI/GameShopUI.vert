#version 330
#extension GL_ARB_explicit_uniform_location : require

layout (location=0) in vec3 inputPosition;
layout (location=1) in vec2 texCoord;
out vec2 texCoord1;

void main(){
     
    texCoord1 = texCoord;
     
   
    gl_Position = vec4((inputPosition.x - 1.0) * (3.0 / 7.0), inputPosition.y * (3.0/4.0), 0.0, 1.0);
}