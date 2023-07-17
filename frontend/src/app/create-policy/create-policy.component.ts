import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-policy',
  templateUrl: './create-policy.component.html',
  styleUrls: ['./create-policy.component.css'],
})
export class CreatePolicyComponent implements OnInit {
  public createPolicyForm!: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.createPolicyForm = this.formBuilder.group({
      acceptance: ['', Validators.required],
      acceptedquote: ['', Validators.required],
      amount: ['', Validators.required],
      businessid: ['', Validators.required],
      consumerid: ['', Validators.required],
      duration: ['', Validators.required],
      edate: ['', Validators.required],
      paymentdetails: ['', Validators.required],
      policyid: ['', Validators.required],
      ploicystatus: ['', Validators.required],
    });
  }
  onSubmit() {
    console.log(this.createPolicyForm.value);
    const token = 'bearer' + localStorage.getItem('token');
    let tokenStr = localStorage.getItem('token');
    let tokenStr1 = 'Bearer ' + tokenStr;

    const headers = new HttpHeaders().set('Authorization', tokenStr1);
    headers.set('Access-Control-Allow-Origin', 'http://localhost:8081');

    // headers.set('Accept', 'application/json');
    let consumerId = this.createPolicyForm.value.consumerid;
    let _url = 'http://localhost:8081/createPolicy?id=' + consumerId;
    this.http
      .post(_url, this.createPolicyForm.value, {
        headers,
        responseType: 'text' as 'json',
      })
      .subscribe(
        (res: any) => {
          alert('Details updated successfully');
          JSON.stringify(this.createPolicyForm.reset());
          this.router.navigate(['policy']);
          console.log('resp: ', res);
        },
        (err) => {
          console.log('Error: ', err);
          // alert('Something went wrong' + err);
        }
      );
  }
}
