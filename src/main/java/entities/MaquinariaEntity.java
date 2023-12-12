package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "maquinaria", schema = "constructora", catalog = "")
public class MaquinariaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "matricula", nullable = false, length = 7)
    private String matricula;
    @Basic
    @Column(name = "modelo", nullable = false, length = 20)
    private String modelo;
    @Basic
    @Column(name = "empleado", nullable = true, length = 9)
    private String empleado;
    @Basic
    @Column(name = "nombreObra", nullable = true, length = 50)
    private String nombreObra;
    @ManyToOne
    @JoinColumn(name = "empleado", referencedColumnName = "dni")
    private EmpleadoEntity empleadoByEmpleado;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaquinariaEntity that = (MaquinariaEntity) o;

        if (matricula != null ? !matricula.equals(that.matricula) : that.matricula != null) return false;
        if (modelo != null ? !modelo.equals(that.modelo) : that.modelo != null) return false;
        if (empleado != null ? !empleado.equals(that.empleado) : that.empleado != null) return false;
        if (nombreObra != null ? !nombreObra.equals(that.nombreObra) : that.nombreObra != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = matricula != null ? matricula.hashCode() : 0;
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (empleado != null ? empleado.hashCode() : 0);
        result = 31 * result + (nombreObra != null ? nombreObra.hashCode() : 0);
        return result;
    }

    public EmpleadoEntity getEmpleadoByEmpleado() {
        return empleadoByEmpleado;
    }

    public void setEmpleadoByEmpleado(EmpleadoEntity empleadoByEmpleado) {
        this.empleadoByEmpleado = empleadoByEmpleado;
    }
}
