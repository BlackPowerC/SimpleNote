package com.blackpowerc.jee7;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@NamedQueries(
        {
                @NamedQuery(name="note.findAll", query = "SELECT n FROM Note n"),
                @NamedQuery(name="note.findById", query = "SELECT n FROM Note n WHERE n.id = :id"),
                @NamedQuery(name="note.deleteAll", query = "DELETE FROM Note n"),
                @NamedQuery(name="note.deleteById", query = "DELETE FROM Note n WHERE n.id = :id"),
        }
)
@Entity
@Table(name = "notes")
public class Note
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id ;

    @Size(max = 127, min = 5, message = "The title of a note must be between 127 and 5 characters")
    @Column(name = "title", nullable = false, length = 127)
    private String title ;

    @NotNull
    @Size(max = 1023, min = 100, message = "The content of a note must be between 1023 and 10 characters")
    @Column(name = "content", nullable = false, length = 1023)
    private String content ;

    @Temporal(TemporalType.DATE)
    private LocalDate publicationDate ;

    public Note(String title, String content, LocalDate publicationDate)
    {
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
    }

    public Note() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("Note{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", publicationDate=").append(publicationDate);
        sb.append('}');
        return sb.toString();
    }
}
