import { Component, OnInit } from '@angular/core';
import { Customer, customerCollection } from '../customer-list/customer-list.component';
import { ActivatedRoute } from '@angular/router';
import { Location } from  '@angular/common';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {

  private customer: Customer

  constructor(
    private route: ActivatedRoute,
    private _location: Location
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      let customerId = +params.get('customerId');
      this.customer = customerCollection[customerId];
    });
  }

  delete(customer: any) {
    if (confirm('Deseja realmente remover o cliente "' + customer.name + '"?')) {
      const index = customerCollection.indexOf(customer, 0);
      if (index > -1) {
        customerCollection.splice(index, 1);
        this.back();
      }
    }
  }

  back() {
    this._location.back();
  }

}