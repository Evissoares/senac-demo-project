import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  //nomes = ["Aristoteles", "platão"];

  private customers: Customer[];



  constructor() { }

  ngOnInit() {
    this.customers = [
      {
        name: "Aristóteles",
        bornDate: "700 A.C.",
        email: "aristoteles@sc.senac.br"
      },
      {
        name: "Socrates",
        bornDate: "700 A.C.",
        email: "aristoteles@sc.senac.br"
      },
      {
        name: "Platão",
        bornDate: "700 A.C.",
        email: "aristoteles@sc.senac.br"
      },

      {
        name: "Tales De Mileto",
        bornDate: "300 A.C.",
        email: null
      }
    ];
  }

  onSubmit(customerForm: NgForm, name: string, born: string, email: string ) {

    if(customerForm.valid) {
      let newCustomer = new Customer();
      newCustomer.name = name;
      newCustomer.bornDate = born;
      newCustomer.email = email;
      this.customers.push(newCustomer);
    }
  }

}

export class Customer {
  name: string;
  bornDate: string;
  email: string;
}