import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from '../shared/api.service';

@Component({
  selector: 'app-quotes',
  templateUrl: './quotes.component.html',
  styleUrls: ['./quotes.component.css'],
})
export class QuotesComponent implements OnInit {
  public quotesForm!: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private api: ApiService
  ) {}

  ngOnInit(): void {
    this.quotesForm = this.formBuilder.group({
      BUSINESS_VALUE: ['', Validators.required],
      PROPERTY_TYPE: ['', Validators.required],
      PROPERTY_VALUE: ['', Validators.required],
    });
  }

  onSubmit() {
    let bVal = this.quotesForm.value.BUSINESS_VALUE;
    let pVal = this.quotesForm.value.PROPERTY_VALUE;

    let tokenStr = localStorage.getItem('token');
    let tokenStr1 = 'Bearer ' + tokenStr;

    const headers = new HttpHeaders().set('Authorization', tokenStr1);

    this.api
      .getQuotes(bVal, pVal, headers)
      .toPromise()
      .then((res) => {
        let data = JSON.parse(res);
        console.log('Promise data: ', data);
      })
      .catch((err) => {
        console.log('Error: ', err);
      });
  }
}
