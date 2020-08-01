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
  private newCustomer: Customer;



  constructor() { }

  ngOnInit() {
    this.customers = customerCollection;
    this.newCustomer = new Customer();
  }

  onSubmit(customerForm: NgForm) {

    if(customerForm.valid) {
      this.customers.push(this.newCustomer);
      this.newCustomer = new Customer();
    }
  }

}

export class Customer {
  name: string;
  bornDate: string;
  email: string;
}

export const customerCollection = [
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
]