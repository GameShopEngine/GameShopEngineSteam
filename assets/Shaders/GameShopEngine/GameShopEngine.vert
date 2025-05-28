#version 330
#extension GL_ARB_explicit_uniform_location : require

layout (location=0) in vec3 inputPosition;
layout (location=1) uniform mat4 projMatrix;
layout (location=3) uniform mat4 modelMatrix;
layout (location=4) uniform mat4 viewMatrix;
layout (location=2) in vec2 texCoord;
out vec2 outTextCoord;

void main()
{
gl_Position = projMatrix * viewMatrix * modelMatrix * vec4(inputPosition, 1.0);
 
    outTextCoord = texCoord;
}