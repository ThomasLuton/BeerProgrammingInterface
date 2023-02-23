import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Role } from '../shared/models/Role';
import { UserAccount } from '../shared/models/UserAccount';
import { RoleUpdate } from '../shared/models/RoleUpdate';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  users?: any;
  roles?: any;

  constructor(private readonly http: HttpClient, private readonly router: Router) {

  }

  ngOnInit(): void {
    this.getAllRoles().subscribe(value => {
      this.roles = value;
    })
    this.getAllAccounts().subscribe(value => {
      this.users = value;
    });
  }
  getAllAccounts(): Observable<UserAccount> {
    const url = "http://localhost:8080/user-accounts";
    return this.http.get<UserAccount>(url);
  }
  getAllRoles(): Observable<Role> {
    const url = "http://localhost:8080/roles";
    return this.http.get<Role>(url);
  }
  putRole(userId: number, newRole: RoleUpdate) {
    const url = `http://localhost:8080/user-accounts/update-role/${userId}`;
    return this.http.put<RoleUpdate>(url, newRole);
  }
  onSubmit(role: string, userId: number) {
    let newRole: RoleUpdate;
    if (role === "Admin") {
      newRole = {
        roleId: 3
      }
    } else if (role === "Modo") {
      newRole = {
        roleId: 2
      }
    } else {
      newRole = {
        roleId: 1
      }
    }
    this.putRole(userId, newRole).subscribe();
    window.location.reload();
  }
}
