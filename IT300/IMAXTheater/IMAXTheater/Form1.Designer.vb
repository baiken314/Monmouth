<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.picImax = New System.Windows.Forms.PictureBox()
        Me.lblTitle = New System.Windows.Forms.Label()
        Me.cboShowType = New System.Windows.Forms.ComboBox()
        Me.lblNumberOfTickets = New System.Windows.Forms.Label()
        Me.txtNumberOfTickets = New System.Windows.Forms.TextBox()
        Me.btnCost = New System.Windows.Forms.Button()
        Me.btnClear = New System.Windows.Forms.Button()
        Me.lblCost = New System.Windows.Forms.Label()
        CType(Me.picImax, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'picImax
        '
        Me.picImax.Image = Global.IMAXTheater.My.Resources.Resources.imax
        Me.picImax.Location = New System.Drawing.Point(0, 0)
        Me.picImax.Name = "picImax"
        Me.picImax.Size = New System.Drawing.Size(380, 451)
        Me.picImax.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.picImax.TabIndex = 0
        Me.picImax.TabStop = False
        '
        'lblTitle
        '
        Me.lblTitle.AutoSize = True
        Me.lblTitle.Font = New System.Drawing.Font("Broadway", 24.0!)
        Me.lblTitle.Location = New System.Drawing.Point(392, 27)
        Me.lblTitle.Name = "lblTitle"
        Me.lblTitle.Size = New System.Drawing.Size(385, 36)
        Me.lblTitle.TabIndex = 1
        Me.lblTitle.Text = "IMAX Theater Tickets"
        '
        'cboShowType
        '
        Me.cboShowType.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.cboShowType.FormattingEnabled = True
        Me.cboShowType.Items.AddRange(New Object() {"Matinee ($16)", "Evening ($27)"})
        Me.cboShowType.Location = New System.Drawing.Point(513, 83)
        Me.cboShowType.Name = "cboShowType"
        Me.cboShowType.Size = New System.Drawing.Size(143, 28)
        Me.cboShowType.TabIndex = 2
        '
        'lblNumberOfTickets
        '
        Me.lblNumberOfTickets.AutoSize = True
        Me.lblNumberOfTickets.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblNumberOfTickets.Location = New System.Drawing.Point(491, 138)
        Me.lblNumberOfTickets.Name = "lblNumberOfTickets"
        Me.lblNumberOfTickets.Size = New System.Drawing.Size(186, 24)
        Me.lblNumberOfTickets.TabIndex = 3
        Me.lblNumberOfTickets.Text = "Number of Tickets:"
        Me.lblNumberOfTickets.Visible = False
        '
        'txtNumberOfTickets
        '
        Me.txtNumberOfTickets.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtNumberOfTickets.Location = New System.Drawing.Point(557, 190)
        Me.txtNumberOfTickets.Name = "txtNumberOfTickets"
        Me.txtNumberOfTickets.Size = New System.Drawing.Size(55, 26)
        Me.txtNumberOfTickets.TabIndex = 4
        Me.txtNumberOfTickets.Visible = False
        '
        'btnCost
        '
        Me.btnCost.BackColor = System.Drawing.SystemColors.MenuHighlight
        Me.btnCost.DialogResult = System.Windows.Forms.DialogResult.Cancel
        Me.btnCost.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnCost.ForeColor = System.Drawing.SystemColors.ButtonHighlight
        Me.btnCost.Location = New System.Drawing.Point(504, 251)
        Me.btnCost.Name = "btnCost"
        Me.btnCost.Size = New System.Drawing.Size(160, 53)
        Me.btnCost.TabIndex = 5
        Me.btnCost.Text = "Ticket Cost"
        Me.btnCost.UseVisualStyleBackColor = False
        Me.btnCost.Visible = False
        '
        'btnClear
        '
        Me.btnClear.BackColor = System.Drawing.SystemColors.MenuHighlight
        Me.btnClear.DialogResult = System.Windows.Forms.DialogResult.Cancel
        Me.btnClear.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnClear.ForeColor = System.Drawing.SystemColors.ButtonHighlight
        Me.btnClear.Location = New System.Drawing.Point(504, 310)
        Me.btnClear.Name = "btnClear"
        Me.btnClear.Size = New System.Drawing.Size(160, 53)
        Me.btnClear.TabIndex = 6
        Me.btnClear.Text = "Clear Form"
        Me.btnClear.UseVisualStyleBackColor = False
        Me.btnClear.Visible = False
        '
        'lblCost
        '
        Me.lblCost.AutoSize = True
        Me.lblCost.BackColor = System.Drawing.SystemColors.MenuHighlight
        Me.lblCost.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblCost.ForeColor = System.Drawing.SystemColors.ButtonHighlight
        Me.lblCost.Location = New System.Drawing.Point(492, 390)
        Me.lblCost.Name = "lblCost"
        Me.lblCost.Size = New System.Drawing.Size(72, 24)
        Me.lblCost.TabIndex = 7
        Me.lblCost.Text = "Label1"
        Me.lblCost.Visible = False
        '
        'Form1
        '
        Me.AcceptButton = Me.btnCost
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.CancelButton = Me.btnClear
        Me.ClientSize = New System.Drawing.Size(790, 450)
        Me.Controls.Add(Me.lblCost)
        Me.Controls.Add(Me.btnClear)
        Me.Controls.Add(Me.btnCost)
        Me.Controls.Add(Me.txtNumberOfTickets)
        Me.Controls.Add(Me.lblNumberOfTickets)
        Me.Controls.Add(Me.cboShowType)
        Me.Controls.Add(Me.lblTitle)
        Me.Controls.Add(Me.picImax)
        Me.Name = "Form1"
        Me.Text = "IMAX Tickets"
        CType(Me.picImax, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents picImax As PictureBox
    Friend WithEvents lblTitle As Label
    Friend WithEvents cboShowType As ComboBox
    Friend WithEvents lblNumberOfTickets As Label
    Friend WithEvents txtNumberOfTickets As TextBox
    Friend WithEvents btnCost As Button
    Friend WithEvents btnClear As Button
    Friend WithEvents lblCost As Label
End Class
