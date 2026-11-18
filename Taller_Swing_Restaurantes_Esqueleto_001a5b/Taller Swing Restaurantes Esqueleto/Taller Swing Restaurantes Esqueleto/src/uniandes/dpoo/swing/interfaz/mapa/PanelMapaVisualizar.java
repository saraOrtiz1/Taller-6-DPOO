package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    /**
     * La etiqueta donde se dibuja el mapa y se hacen las señales de los restaurantes
     */
    private JLabel labMapa;

    /**
     * La lista de restaurantes que se están dibujando en el mapa
     */
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar( )
    {
        // Cargamos la imagen original de forma segura
        java.net.URL imageUrl = getClass( ).getResource( "/imagenes/mapa.png" );
        
        if( imageUrl != null )
        {
            this.labMapa = new JLabel( new ImageIcon( imageUrl ) );
        }
        else
        {
            this.labMapa = new JLabel( "No se encontró la imagen del mapa" );
        }
        
        labMapa.setBorder( new LineBorder( Color.DARK_GRAY ) );
        add( labMapa, BorderLayout.CENTER );
    }

    @Override
    public void paint( Graphics g )
    {
        super.paint( g );
        Graphics2D g2d = ( Graphics2D )g;
        if( restaurantes != null )
        {
            g2d.setColor( Color.RED );

            int offX = labMapa.getX( );
            int offY = labMapa.getY( );

            for( Restaurante r : restaurantes )
            {
                int x = offX + r.getX( );
                int y = offY + r.getY( );

                // Dibuja el punto rojo de ubicación
                g2d.fillOval( x - 4, y - 4, 8, 8 );

                // Dibuja el nombre del restaurante al lado del punto
                g2d.drawString( r.getNombre( ), x + 6, y + 4 );
            }
        }
    }

    /**
     * Actualiza la lista de restaurantes y llama al método repaint() para que se actualice el mapa
     * @param nuevosRestaurantes
     */
    public void actualizarMapa( List<Restaurante> nuevosRestaurantes )
    {
        if( restaurantes != null )
        {
            this.restaurantes.clear( );
            this.restaurantes.addAll( nuevosRestaurantes );
        }
        else
        {
            this.restaurantes = nuevosRestaurantes;
        }
        repaint( );
    }
}
