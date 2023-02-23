import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserAccount } from '../shared/models/UserAccount';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

  signUp = new FormGroup({
    pseudo: new FormControl('', [Validators.required, Validators.minLength(4), Validators.maxLength(255)]),
    mail: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.pattern(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[%||!||*])(?!.* ).{8,42}/)])
  })

  inputs: UserAccount = {
    pseudo: "",
    mail: "",
    password: ""
  }

  constructor(private readonly http: HttpClient) {

  }

  onSubmit(): void {
    if (this.signUp.valid) {
      this.inputs = this.signUp.value as UserAccount;
      this.createAccount(this.inputs).subscribe();
      this.signUp.reset();
    }
  }
  createAccount(inputs: UserAccount): Observable<UserAccount> {
    const url = "http://localhost:8080/user-accounts/sign-up";
    return this.http.post<UserAccount>(url, inputs);
  }
}
