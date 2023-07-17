import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../shared/api.service';
import { PolicyComponent } from '../policy/policy.component';
import { find, observable, Subscription } from 'rxjs';
import { FormGroup } from '@angular/forms';
import { PolicyDataService } from '../policy-data.service';

@Component({
  selector: 'app-view-detail-policy',
  templateUrl: './view-detail-policy.component.html',
  styleUrls: ['./view-detail-policy.component.css'],
})
export class ViewDetailPolicyComponent implements OnInit {
  //currentLocation = window.location;

  public policyData: any;
  public subscription: Subscription | undefined;
  public data: any;

  public policyId: any;
  public policy!: PolicyComponent;
  public displayForm!: FormGroup;
  constructor(
    private route: ActivatedRoute,
    private api: ApiService,
    private _policyService: PolicyDataService
  ) {
    // route.params.subscribe((params) => {
    //   console.log('data from view policy: ', params);
    //   this.policyId = params['id'];
    // });
  }

  ngOnInit(): void {
    //this.policy=this.api.find(this.policyId);
    //console.log(location.href);
    this.subscription = this._policyService.currentMessage.subscribe(
      (policyData) => (this.policyData = policyData)
    );
    console.log(this.policyData);
    this.data = JSON.parse(this.policyData);

    this.route.paramMap.subscribe((params) => {
      this.policyId = params.get('id');
      this.api.find(this.policyId);
    });
  }

  ngOnDestroy() {
    this.subscription?.unsubscribe();
  }
}
