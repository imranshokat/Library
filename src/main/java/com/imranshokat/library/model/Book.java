package com.imranshokat.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(of={"id"},callSuper=false)
@Table(name="book_entity")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
    @NonNull
    @Length(max=50)
	private String title;
	
	@NotNull
    @NonNull
    @Length(max=50)
    private String author;
    
    @NotNull
    @NonNull
    @Length(max=100)
    private String description;
    
    @NotNull
    @NonNull
    @Length(max=50)
    private String price;
    
    @NotNull
    @NonNull
    @Length(max=50)
    private String genre;
    
    @NotNull
    @NonNull
    @Length(max=50)
    private String publishDate;
    
}
