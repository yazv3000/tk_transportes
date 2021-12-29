package tk.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

import tk.modelo.Cliente;
import tk.modeloDAO.ClienteDAO;
import tk.vista.Autenticacion;
import tk.vista.Registro;

public class CtrlRegistro implements ActionListener, MouseInputListener{
	
	// VISTA
	Registro re;
	
	// OBJETOS 
	Cliente objCliente;
	ClienteDAO clDao = new ClienteDAO();
	
	//CONSTRUCTOR
	public CtrlRegistro(Registro formulario_re) {
		this.re = formulario_re;
		this.re.btnRegistrar.addActionListener(this);
		this.re.lblInicieSesion.addMouseListener(this);
		this.re.btnVolver.addActionListener(this);
		this.re.txtCodigo.setText(clDao.generarCodigo()+"");
	}
	
	// EVENTOS
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == re.btnRegistrar) {
			if(validarNoVacio()) {
				if(registrarCliente()) {
		        Autenticacion login = new Autenticacion();
				CtrlAutenticacion ctrl_login = new CtrlAutenticacion(login); 
				login.setVisible(true);
				re.dispose();
				}
			}
			else {
				JOptionPane.showMessageDialog(re, "Primero llene todos los campos");
			}
		}
		
		if(e.getSource() == re.btnVolver) {
        	Autenticacion login = new Autenticacion();
			CtrlAutenticacion ctrl_login = new CtrlAutenticacion(login); 
			login.setVisible(true);
			re.dispose();
		}
	}
		
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == re.lblInicieSesion){
        	Autenticacion login = new Autenticacion();
        	CtrlAutenticacion ctrl_login = new CtrlAutenticacion(login); 
			login.setVisible(true);
			re.dispose();
		}
    }
    //METODOS PUBLICOS
    public boolean registrarCliente(){
    	
    	String nombre = re.txtNombres.getText().trim();
		String apepa = re.txtApePat.getText().trim();
		String apemat = re.txtApeMat.getText().trim();
		if(apemat.isEmpty()) 	apemat = null;
		
		String sexo;
		if(re.comboBox_sx.getSelectedItem().equals("MASCULINO")) 	sexo = "M";
		else 	sexo = "F";
		
		int dni, celular;
		
		try{
			dni = Integer.parseInt(re.txtDni.getText());
			celular = Integer.parseInt(re.txtCelular.getText());
		}
		catch (Exception e) {
	        JOptionPane.showMessageDialog(re, "Error. Debe ingresar un número en los campos DNI y celular");
			return false;
		}
		
		String direc = re.txtDireccion.getText();
		String email = re.txtEmail.getText();
		
		// Encriptando la contraseña
		String password = new String(re.passwordField.getPassword());		// passwordField retorna un char[]
		
		objCliente = new Cliente(nombre, apepa, apemat, dni, sexo, celular, direc, email, password);
		
		int insertar = clDao.insertar(objCliente);
		
		if (insertar == 1) {
            JOptionPane.showMessageDialog(re, "Se ha registrado con éxito.");
			return true;
        } else {
            JOptionPane.showMessageDialog(re, "No se pudo registrar");
			return false;
        }
    }
    private boolean validarNoVacio() {
		return !re.txtNombres.getText().isEmpty() 
				&& !re.txtApePat.getText().isEmpty() 
				&& !re.txtDni.getText().isEmpty()
				&& !re.txtCelular.getText().isEmpty()
				&& !re.txtDireccion.getText().isEmpty()
				&& !re.txtEmail.getText().isEmpty()
				&& re.passwordField.getPassword()!=null;
	}
    
	// OTROS MÉTODOS DE LA INTERFAZ MOUSE_INPUT_LISTENER
    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) {	}

    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) {	}
}
