#include <GL/glut.h>
#include <stdlib.h>
#include <stdio.h>

static GLfloat psize = 7.0;
static GLfloat pmax[1];
static GLfloat constant[3] = {1.0, 0.0, 0.0};
static GLfloat linear[3] = {0.0, 0.12, 0.0};
static GLfloat quadratic[3] = {0.0, 0.0, 0.01};

void init(void) 
{
   int i;

   srand (12345);
   
   glNewList(1, GL_COMPILE);
   glBegin (GL_POINTS);
      for (i = 0; i < 250; i++) {
          glColor3f (1.0, ((rand()/(float) RAND_MAX) * 0.5) + 0.5, 
                          rand()/(float) RAND_MAX);
/*  randomly generated vertices:
    -5 < x < 5;  -5 < y < 5;  -5 < z < -45  */
          glVertex3f ( ((rand()/(float)RAND_MAX) * 10.0) - 5.0, 
                       ((rand()/(float)RAND_MAX) * 10.0) - 5.0, 
                       ((rand()/(float)RAND_MAX) * 40.0) - 45.0); 
      }
   glEnd();
   glEndList();

   glEnable(GL_DEPTH_TEST);
   glEnable(GL_POINT_SMOOTH);
   glEnable(GL_BLEND);
   glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA); 
   glPointSize(psize);
}

void display(void)
{
   glClear (GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glCallList (1);
   glutSwapBuffers ();
}

void reshape (int w, int h)
{
   glViewport (0, 0, (GLsizei) w, (GLsizei) h);
   glMatrixMode (GL_PROJECTION);
   glLoadIdentity ();
   gluPerspective (35.0, 1.0, 0.25, 200.0);
   glMatrixMode (GL_MODELVIEW);
   glTranslatef (0.0, 0.0, -10.0);
}

int main(int argc, char** argv)
{
   glutInit(&argc, argv);
   glutInitDisplayMode (GLUT_RGB | GLUT_DOUBLE | GLUT_DEPTH | GLUT_MULTISAMPLE);
   glutInitWindowSize (400, 400); 
   glutInitWindowPosition (100, 100);
   glutCreateWindow ("显示图形");
   init ();
   glutDisplayFunc (display); 
   glutReshapeFunc (reshape);
   glutMainLoop();
   return 0;
}
 