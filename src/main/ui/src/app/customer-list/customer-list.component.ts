import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  //nomes = ["Aristoteles", "platão"];

  private customerList: Customer[];
  private newCustomer = new Customer();



  constructor() { }

  ngOnInit() {
    this.customerList = [
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

  onSubmit(customerForm: NgForm) {

    if(customerForm.valid) {
      this.customerList.push(this.newCustomer);
    }
  }

}

export class Customer {
  name: string;
  bornDate: string;
  email: string;
}