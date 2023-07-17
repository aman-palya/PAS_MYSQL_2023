import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PolicyDataService {
  private messageSource = new BehaviorSubject('default');
  currentMessage = this.messageSource.asObservable();

  constructor() {}

  updatePolicyData(data: any) {
    this.messageSource.next(data);
  }
}
