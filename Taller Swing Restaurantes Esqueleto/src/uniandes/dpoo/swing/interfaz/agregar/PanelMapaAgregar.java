package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PanelMapaAgregar extends JPanel implements MouseListener
{
    /**
     * La etiqueta donde se muestra el mapa y donde se debe marcar la ubicación del nuevo restaurante
     */
    private JLabel labMapa;

    /**
     * La coordenada X del nuevo restaurante
     */
    private int x;

    /**
     * La coordenada Y del nuevo restaurante
     */
    private int y;

    public PanelMapaAgregar( )
    {
    	java.net.URL imageUrl = getClass( ).getResource( "/imagenes/mapa.png" );
        if( imageUrl != null )
        {
            ImageIcon iconoOriginal = new ImageIcon( imageUrl );
            this.labMapa = new JLabel( iconoOriginal );
        }
        else
        {
            this.labMapa = new JLabel( "No se encontró el mapa" );
        }

        labMapa.setBorder( new LineBorder( Color.DARK_GRAY ) );
        labMapa.addMouseListener( this );
        add( labMapa );

        this.x = -1; 
        this.y = -1;
    }

    /**
     * Retorna las coordenadas del restaurante
     * @return
     */
    public int[] getCoordenadas( )
    {
        return new int[]{ x, y };
    }

    @Override
    public void paint( Graphics g )
    {
    	super.paint( g );

        if( x != -1 && y != -1 )
        {
            Graphics2D g2d = ( Graphics2D )g;
            g2d.setColor( Color.red );
            int posX = labMapa.getX( ) + x;
            int posY = labMapa.getY( ) + y;
            g2d.fillOval( posX - 3, posY - 3, 7, 7 );
        }
    }

    @Override
    public void mouseClicked( MouseEvent e )
    {
        this.x = e.getX( );
        this.y = e.getY( );
        repaint( );
    }

    @Override
    public void mousePressed( MouseEvent e )
    {
    }

    @Override
    public void mouseReleased( MouseEvent e )
    {
    }

    @Override
    public void mouseEntered( MouseEvent e )
    {
    }

    @Override
    public void mouseExited( MouseEvent e )
    {
    }

}
