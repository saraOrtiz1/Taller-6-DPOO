package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {
    	setLayout( new GridLayout( 3, 1 ) );

        // 1. Fila para el Nombre
        JPanel panelNombre = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        panelNombre.add( new JLabel( "Nombre: " ) );
        txtNombre = new JTextField( 15 );
        panelNombre.add( txtNombre );
        add( panelNombre );

        // 2. Fila para la Calificación ("1" a "5")
        JPanel panelCalificacion = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        panelCalificacion.add( new JLabel( "Calificación: " ) );
        String[] opcionesCalificacion = { "1", "2", "3", "4", "5" };
        cbbCalificacion = new JComboBox<>( opcionesCalificacion );
        panelCalificacion.add( cbbCalificacion );
        add( panelCalificacion );

        // 3. Fila para Visitado ("Sí" / "No")
        JPanel panelVisitado = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        panelVisitado.add( new JLabel( "Visitado: " ) );
        String[] opcionesVisitado = { "Sí", "No" };
        cbbVisitado = new JComboBox<>( opcionesVisitado );
        panelVisitado.add( cbbVisitado );
        add( panelVisitado );

    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado( )
    {
        
    	String visitadoStr = ( String ) cbbVisitado.getSelectedItem( );
        return visitadoStr.equals( "Sí" );
    }

    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre( )
    {
    	return txtNombre.getText( );
    }
}
