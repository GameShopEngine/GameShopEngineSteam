#version 330
in vec2 texCoord1;
uniform vec4 m_Color;
uniform sampler2D m_ColorMap;
out vec4 fragColor;

void main(){
    //returning the color of the pixel (here solid blue)
    //- gl_FragColor is the standard GLSL variable that holds the pixel
    //color. It must be filled in the Fragment Shader.
  
        fragColor = m_Color * texture2D(m_ColorMap, texCoord1);
     
}