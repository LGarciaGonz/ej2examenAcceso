package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "empleado", schema = "constructora", catalog = "")
public class EmpleadoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dni", nullable = false, length = 9)
    private String dni;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "sueldo", nullable = true, precision = 0)
    private Double sueldo;
    @Basic
    @Column(name = "nombreObra", nullable = true, length = 50)
    private String nombreObra;
    @OneToMany(mappedBy = "empleadoByEmpleado")
    private Collection<MaquinariaEntity> maquinariasByDni;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
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

        EmpleadoEntity that = (EmpleadoEntity) o;

        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (sueldo != null ? !sueldo.equals(that.sueldo) : that.sueldo != null) return false;
        if (nombreObra != null ? !nombreObra.equals(that.nombreObra) : that.nombreObra != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dni != null ? dni.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (sueldo != null ? sueldo.hashCode() : 0);
        result = 31 * result + (nombreObra != null ? nombreObra.hashCode() : 0);
        return result;
    }

    public Collection<MaquinariaEntity> getMaquinariasByDni() {
        return maquinariasByDni;
    }

    public void setMaquinariasByDni(Collection<MaquinariaEntity> maquinariasByDni) {
        this.maquinariasByDni = maquinariasByDni;
    }
}
