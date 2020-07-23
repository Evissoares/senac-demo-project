import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  //nomes = ["Aristoteles", "platão"];

  customers = [
    {
      nome: "Aristóteles",
      dataNascimento: "700 A.C.",
      email: "aristoteles@sc.senac.br"
    },
  
    {
      nome: "Sócrates",
      dataNascimento: "800 A.C.",
      email: "socretes@sc.senac.br"
    },

    {
      nome: "Platão",
      dataNascimento: "500 A.C.",
      email: "platao@sc.senac.br"
    }

  ];

  constructor() { }

  ngOnInit() {
  }

}