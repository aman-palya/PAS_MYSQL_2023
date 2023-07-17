import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {
  HttpClient,
  HttpHeaders,
  JsonpClientBackend,
} from '@angular/common/http';
import { Router } from '@angular/router';
import { PolicyComponent } from '../policy/policy.component';
import { ApiService } from '../shared/api.service';

@Component({
  selector: 'app-issue-policy',
  templateUrl: './issue-policy.component.html',
  styleUrls: ['./issue-policy.component.css'],
})
export class IssuePolicyComponent implements OnInit {
  public issueForm!: FormGroup;
  public policy!: PolicyComponent;
  public issuePolicyData: any = {
    acceptedQuote: null,
    businessid: null,
    consumerid: null,
    pDetails: null,
    policyid: null,
  };

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private api: ApiService
  ) {}

  ngOnInit(): void {
    this.issueForm = this.formBuilder.group({
      policyId: ['', Validators.required],
      consumerId: ['', Validators.required],
      businessId: ['', Validators.required],
      paymentDetails: ['', Validators.required],
      STATUS: ['', Validators.required],
    });
  }

  onSubmit() {
    this.issuePolicyData.acceptedQuote = this.issueForm.value.STATUS;
    this.issuePolicyData.businessid = this.issueForm.value.businessId;
    this.issuePolicyData.consumerid = String(this.issueForm.value.consumerId);
    this.issuePolicyData.pDetails = this.issueForm.value.paymentDetails;
    this.issuePolicyData.policyid = this.issueForm.value.policyId;

    let jsonStr = JSON.stringify(this.issuePolicyData);
    let jsonObj = JSON.parse(jsonStr);
    console.log('json: ', jsonStr);

    const token = 'bearer' + localStorage.getItem('token');
    let tokenStr = localStorage.getItem('token');
    let tokenStr1 = 'Bearer ' + tokenStr;

    const headers = new HttpHeaders().set('Authorization', tokenStr1);

    this.http
      .post<any>('http://localhost:8081/issuePolicy', jsonObj, {
        headers,
        responseType: 'text' as 'json',
      })
      .subscribe(
        (res) => {
          alert('Policy issued successfully');
          this.issueForm.reset();

          this.router.navigate(['policy']);
        },
        (err) => {
          console.log('error: ', err);
          alert('Something went wrong');
        }
      );
  }
}
