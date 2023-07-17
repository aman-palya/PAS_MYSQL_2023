import { Component, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { vPolicy } from 'src/model/vPolicy.model';
import { ApiService } from '../shared/api.service';
import { NgModule } from '@angular/core';
import { PolicyDataService } from '../policy-data.service';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-view-policy',
  templateUrl: './view-policy.component.html',
  styleUrls: ['./view-policy.component.css'],
})
export class ViewPolicyComponent implements OnInit {
  public viewPolicyForm!: FormGroup;
  public objPolicy: vPolicy = new vPolicy();

  public PolicyData: any;
  subscription:
    | Subscription
    //policyId=0;
    | undefined;

  //policyId=0;
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private route: ActivatedRoute,
    private api: ApiService,
    private _policyService: PolicyDataService
  ) {}

  ngOnInit(): void {
    this.subscription = this._policyService.currentMessage.subscribe(
      (PolicyData) => (this.PolicyData = PolicyData)
    );
    this.viewPolicyForm = this.formBuilder.group({
      consumerId: ['', Validators.required],
      policyId: ['', Validators.required],
    });
  }

  ngOnDestroy() {
    this.subscription?.unsubscribe();
  }

  onSubmit() {
    const cId = this.viewPolicyForm.value.consumerId;
    const pId = this.viewPolicyForm.value.policyId;
    const url = 'http://localhost:8081/viewPolicy/' + cId + '/' + pId;

    let tokenStr = localStorage.getItem('token');
    let tokenStr1 = 'Bearer ' + tokenStr;

    const headers = new HttpHeaders().set('Authorization', tokenStr1);

    this.http
      .get(url, {
        headers,
        responseType: 'text' as 'json',
      })
      .subscribe(
        (res) => {
          console.log('resp: ', res);
          this.objPolicy.policyId = this.viewPolicyForm.value.policyId;
          this.objPolicy.consumerId = this.viewPolicyForm.value.consumerId;

          // this.objPolicy = { ...res };
          this.PolicyData = res;
          this._policyService.updatePolicyData(this.PolicyData);
          //this.api.setPid(this.objPolicy.policyId);
          this.viewPolicyForm.reset();

          // this.router.navigate(['viewDetailPolicy/' + this.objPolicy]);
          this.router.navigate(['viewDetailPolicy']);
        },
        (err) => {
          console.log('Error: ', err);
          alert('Something went wrong');
        }
      );
  }
}
