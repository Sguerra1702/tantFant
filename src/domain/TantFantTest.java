package domain;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.*;
import org.junit.*;

public class TantFantTest {
    
    private Tablero tableroT;

    //import org.junit.internal.runners.statements.Fail;
    
        @Before
        public void setUp(){
            
            tableroT = new Tablero();

        }
    
        @After
        public void tearDown()
        {
    
        }    
    
        @Test
        public void cannotAddMoreThanTwoPlayers(){
            try{
                tableroT.addJugador("parralol", Color.GREEN, 1);
                tableroT.addJugador("xd", Color.DARK_GRAY, 2);
                tableroT.addJugador("lattetona", Color.ORANGE, 3);
                assertFalse(true);
            }catch(TantFantException e){
                assertTrue(true);
            }
        }
    
        @Test
        public void cannotAddSameName(){
            try{
                tableroT.addJugador("parralol", Color.GREEN, 1);
                tableroT.addJugador("parralol", Color.DARK_GRAY, 2);
                assertFalse(true);
            }catch(TantFantException e){
                assertTrue(true);
            }
        }
    
        @Test
        public void cannotAddSameColor(){

            try{
                tableroT.addJugador("parralol", Color.GREEN, 2);
                tableroT.addJugador("xd", Color.GREEN, 1);
                assertFalse(true);
            }catch(TantFantException e){
                assertTrue(true);
            }
        }
    
        @Test
        public void cannotAddSameColorAndSameName(){
            try{
                tableroT.addJugador("parralol", Color.GREEN, 1);
                tableroT.addJugador("parralol", Color.GREEN, 2);
                assertFalse(true);
            }catch(TantFantException e){
                assertTrue(true);
            }
        }
    
        @Test
        public void shouldNotBeBothPlayer1Or2(){

            try{
                tableroT.addJugador("parralol", Color.GREEN, 1);
                tableroT.addJugador("xs", Color.BLUE, 1);
                assertFalse(true);
            }catch(TantFantException e){
                assertTrue(true);
            }

        }
    
        @Test
        public void shouldCreatePlayer(){
            try{
                tableroT.addJugador("parralol", Color.GREEN, 1);
                tableroT.addJugador("xd", Color.DARK_GRAY, 2);
                assertFalse(false);
            }catch(TantFantException e){
                assertTrue(e.getMessage(),false);
            }

        }
    
        @Test
        public void shouldMoveFicha(){
            
        }
    
    
    
    
        @Test
        public void shouldMove(){

            }
        
    }
