import { Component, OnInit } from '@angular/core';
import { Persona } from '../../models/persona';
import { PersonaService } from '../../services/persona.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

declare var $: any;

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit {

  personas: Persona[] | any;
  persona: Persona | any;
  personaForm: FormGroup;
  submitted = false;

  constructor(private personaService: PersonaService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    // Iniciar el formulario vacio 
    this.personaForm = this.formBuilder.group({
      id:[''],
      nombre:['', Validators.required],
      apellidos:['', Validators.required],
      fecha_nacimiento:['', Validators.required],
      domicilio:['', Validators.required],
      rfc:['', Validators.required]
    })

    // Consultar la lista de personas
    this.getPersonas();
  }


  // Consultar lista de personas
  getPersonas(){
    /*
    this.personas = [];
    this.personaService.getPersonas().subscribe(
      res => {
        this.personas = res;
      },
      err => console.error(err)
    )*/
    this.personas = [];
    this.personas = [ new Persona("1","Felipe","Alberto Luna","1997-08-23","CDMX","FALV344643"),
                      new Persona("2","Jorge","Ramos Montoya","1997-09-23","CDMX","SSFHA12345")];



  }

  // Consultar a una persona
  getPersona(id){
    this.persona = null;
    this.personaService.getPersona(id).subscribe(
      res => {
        this.persona = res;
      },
      err => console.error(err)
    )
  }

  // Eliminar una persona
  deletePersona(id){
    this.persona = null;
    this.personaService.deletePersona(id).subscribe(
      res => {
        this.getPersonas();
      },
      err => console.error(err)
    )
  }

  // Crear una persona
  createPersona(){
    this.submitted = true;
    if(this.personaForm.invalid){
      console.log('Formulario Invalido');
      return;
    }

    this.personaService.createPersona(this.personaForm.value).subscribe(
      res => {
        this.getPersonas();
      },
      err => console.error(err)
    )




  }

  // Actualizar una persona
  updatePersona(){
    this.submitted = true;

    if(this.personaForm.invalid){
      console.log("Furmulario invalido");
      return;
    }

    this.personaService.updatePersona(this.personaForm.value).subscribe(
      res => {
        this.getPersonas();
      },
      err => console.error(err)
    )
  }

  // Esta funcion nos ayuda a realizar las validaciones especificadas al inicio
  // de nuestro formulario
  get f() {return this.personaForm.controls;}



}
