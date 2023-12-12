package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "obra", schema = "constructora", catalog = "")
public class ObraEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @Basic
    @Column(name = "entrega", nullable = true)
    private Date entrega;
    @ManyToOne
    @JoinColumn(name = "nombre", referencedColumnName = "nombreObra", nullable = false)
    private EmpleadoEntity empleadoByNombre;
    @ManyToOne
    @JoinColumn(name = "nombre", referencedColumnName = "nombreObra", nullable = false)
    private MaquinariaEntity maquinariaByNombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObraEntity that = (ObraEntity) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (entrega != null ? !entrega.equals(that.entrega) : that.entrega != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (entrega != null ? entrega.hashCode() : 0);
        return result;
    }

    public EmpleadoEntity getEmpleadoByNombre() {
        return empleadoByNombre;
    }

    public void setEmpleadoByNombre(EmpleadoEntity empleadoByNombre) {
        this.empleadoByNombre = empleadoByNombre;
    }

    public MaquinariaEntity getMaquinariaByNombre() {
        return maquinariaByNombre;
    }

    public void setMaquinariaByNombre(MaquinariaEntity maquinariaByNombre) {
        this.maquinariaByNombre = maquinariaByNombre;
    }
}
